public class HospitalERSystem{
    public static class Patient {
    private String name;
    private String surname;
    private String priority; //"emergency" or "normal"

    //Constructor
    public Patient(String name, String surname, String priority) {
        this.name = name;
        this.surname = surname;
        this.priority = priority.toLowerCase();
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Patient: " + name + " " + surname + " , Priority: " + priority;
    }
}


    private QueueAsMyLinkedList<Patient> queue;
    private StackAsMyLinkedList<Patient> history;

    public HospitalERSystem(){
        queue = new QueueAsMyLinkedList<>();
        history = new StackAsMyLinkedList<>();
    }

    public void admitPatient(Patient patient){
        if(patient.getPriority().equals("emergency")){
            queue.priorityInclusion(patient);//if the patient's priority is "emergency", then add to the front of the list
        }
        else{
            //add the normal patients to the list
            queue.enqueue(patient);
        }

        System.out.println(patient + ". Admitted to the queue.");
    }

    public void treatPatient(){
        if(queue.isEmpty()){//check if the queue is empty
            System.out.println("No patients to treat.");
            return;
        }

        Patient treated = queue.dequeue();//take the patient out of the queue
        history.push(treated);//put their details in the stack

        System.out.println("Treated: " + treated);//print the patient details
    }

    public void undoLastTreatment() {
    if (history.isEmpty()) {
        System.out.println("No treatments to undo.");
        return;
    }

    Patient undone = history.pop(); 
    if (undone.getPriority().equals("emergency")) {
        queue.priorityInclusion(undone);
    } else {
        queue.enqueue(undone);
    }

    System.out.println("Undid treatment for: " + undone);
}


    public void displayQueue(){
        System.out.println(queue.toString());
    }

    public void displayHistory(){
        System.out.println(history.toString());
    }
}