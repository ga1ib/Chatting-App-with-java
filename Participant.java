package conversation;

class Participant implements Runnable {
    private String name;
    private boolean active;
    
    

    public Participant(String name) {
        this.name = name;
        this.active = true;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

   

    public void sendMessage(String message) {
    	if (!active) return;
    	if (message.equalsIgnoreCase("bye")) {
    	active = false;
    	}
    	else {
    	System.out.println(name + ": " + message);
    	}
    }
    public boolean hasLeft() {
        return !active;
    }

    @Override
    public void run() {
        while (active) {
            
        }
    }
}
