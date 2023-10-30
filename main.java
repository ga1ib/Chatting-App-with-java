package conversation;

import java.util.Scanner;



public class main {

	
		public static void main(String[] args) {
	        Participant[] p1 = new Participant[3];
	        p1[0] = new Participant("Person 1");
	        p1[1] = new Participant("person 2");
	        p1[2] = new Participant("Person 3");
	        Scanner sc = new Scanner(System.in);

	        Thread[] participantThreads = new Thread[p1.length];
	        for (int i = 0; i < p1.length; i++) {
	            participantThreads[i] = new Thread(p1[i]);
	            participantThreads[i].start();
	        }

	        while (true) {
	            int activeCount = 0;
	            for (Participant participant : p1) {
	                if (participant.isActive()) {
	                    activeCount++;
	                    System.out.println(participant.getName() + ": ");
	                    String message = sc.nextLine();
	                    participant.sendMessage(message);
	                    if (participant.hasLeft()) {
	                        System.out.println(participant.getName() + " has left the conversation.");
	                    }
	                }
	            }
	            if (activeCount <= 1) {
	                System.out.println("All participants have left the chat.");
	                System.exit(0);
	                break;
	            }
	        }
	        sc.close();

	        for (Thread thread : participantThreads) {
	            try {
	                thread.join();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }


	}


