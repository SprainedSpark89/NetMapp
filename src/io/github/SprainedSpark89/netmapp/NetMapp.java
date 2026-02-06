/**
 * 
 */
package io.github.SprainedSpark89.netmapp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;
/**
 * 
 */
public class NetMapp {

	public ServerSocketChannel sSC;
	public static Thread networkingThread;
	public boolean isRunning;
	public Logger log;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Creating New Instance...");
		// allow overriding target via args: host port
		new NetMapp();
	}

	public NetMapp() throws IOException {
		log = Logger.getLogger("NetMapp");

		System.out.println("Opening Networking Socket...");
		sSC = ServerSocketChannel.open();
		sSC.socket().bind(new InetSocketAddress(5565));
		System.out.println("Done!");

		System.out.println("Making Thread");
		networkingThread = new Thread(() -> {
			System.out.println("Started Thread!");
			this.isRunning = true;
			try {
				while (this.isRunning) {
					System.out.println("Waiting for Connection...");
					final SocketChannel accept = sSC.accept();
					if (accept == null) {
						// non-blocking accept; yield briefly
						try { Thread.sleep(50); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
						continue;
					}
					System.out.println("Got Connection! " + accept.getRemoteAddress());

					// Handle the connection in its own thread
					final SocketChannel clientChannel = accept;
					new Thread(() -> {
						try {
							SocketChannel ch = clientChannel;
							System.out.println("Handling client " + ch.getRemoteAddress());
							ByteBuffer buf = ByteBuffer.allocate(8192);
							while (ch.isOpen()) {
								int read = ch.read(buf);
								if (read > 0) {
									buf.flip();
									byte[] data = new byte[buf.remaining()];
									buf.get(data);
									log.info(byteArrayToString(data));
									System.out.println("Hex: " + bytesToHex(data));
									buf.clear();
								} else if (read == -1) {
									System.out.println("Client closed connection: " + ch.getRemoteAddress());
									try { ch.close(); } catch (IOException e) { /* ignore */ }
									break;
								} else {
									// no data available; avoid busy spin
									try { Thread.sleep(50); } catch (InterruptedException e) { Thread.currentThread().interrupt(); break; }
								}
							}
						} catch (IOException e) {
							System.err.println("Connection handler IO error: " + e);
							e.printStackTrace();
						}
					}, "NetMapp-ClientHandler").start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		System.out.println("Done!\nStarting Thread...");
		networkingThread.start();
	}
	
	public String byteArrayToString(byte[] bytes) {
		String out = "";
		for(byte b : bytes) {
			out += b + ",";
		}
		return out;
	}

	// Accept a single client SocketChannel and proxy it to targetHost:targetPort

	private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) sb.append(String.format("%02x", b & 0xff));
        return sb.toString();
    }
}