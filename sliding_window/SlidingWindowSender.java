package sliding_window;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowSender {
    private static final int WINDOW_SIZE = 4;
    private static final int TOTAL_PACKETS = 10;
    
    public static void main(String[] args) {
        Queue<Integer> window = new LinkedList<>();
        int nextPacket = 1;

        while(!window.isEmpty() || nextPacket<=TOTAL_PACKETS){
            while(nextPacket<=TOTAL_PACKETS && window.size() < WINDOW_SIZE){
                window.add(nextPacket);
                System.out.println("Sending the packet: "+nextPacket);
                nextPacket++;
            }

            if(window.size()<=WINDOW_SIZE){
                int curr= window.poll();
                System.out.println("Sending acknowledgement for: "+curr);
            }

            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                Thread.currentThread().interrupt();
            }

        }

    }
}
