import java.util.ArrayList;
import java.util.Scanner;

class Doctor {
    ArrayList<ArrayList<String>> timeSlots;

    Doctor() {
        timeSlots = new ArrayList<>();
        timeSlots.add(new ArrayList<>()); // Morning slot
        timeSlots.add(new ArrayList<>()); // Evening slot
    }
}

public class HospitalAppointment {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Doctor> doctors = new ArrayList<>();

    private void initializeDoctors() {
        for (int i = 0; i < 5; i++) {
            doctors.add(new Doctor());
        }
    }

    private void bookAppointment(int doctorIndex, int timeSlotIndex) {
        Doctor doctor = doctors.get(doctorIndex);

        if (doctor.timeSlots.get(timeSlotIndex).size() < 10) {
            ArrayList<String> patientDetails = setDetails();
            doctor.timeSlots.get(timeSlotIndex).add(String.join(",", patientDetails));
            System.out.println("\nYour slot is booked");
        } else {
            System.out.println("\nAll slots have already been booked");
        }
    }

private void displayAppointments(int doctorIndex) {
    Doctor doctor = doctors.get(doctorIndex);

    for (String timeSlot : doctor.timeSlots.get(0)) {
        displayPatientDetails(timeSlot.split(","));
    }

    for (String timeSlot : doctor.timeSlots.get(1)) {
        displayPatientDetails(timeSlot.split(","));
    }
}


    private void searchDetails(int doctorIndex, int timeSlotIndex) {
        Doctor doctor = doctors.get(doctorIndex);

        System.out.println("\nEnter name of the patient: ");
        sc.nextLine(); 
        String name = sc.nextLine();

        boolean found = false;

        for (String timeSlot : doctor.timeSlots.get(timeSlotIndex)) {
            String[] details = timeSlot.split(",");
            if (details[0].equals(name)) {
                displayPatientDetails(details);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No record found");
        }
    }

    private void cancelAppointment(int doctorIndex, int timeSlotIndex) {
        Doctor doctor = doctors.get(doctorIndex);

        System.out.println("\nEnter name of the patient: ");
        sc.nextLine(); 
        String name = sc.nextLine();

        for (String timeSlot : doctor.timeSlots.get(timeSlotIndex)) {
            String[] details = timeSlot.split(",");
            if (details[0].equals(name)) {
                doctor.timeSlots.get(timeSlotIndex).remove(timeSlot);
                System.out.println("\nAppointment canceled successfully");
                return;
            }
        }

        System.out.println("No record found");
    }

    private ArrayList<String> setDetails() {
        ArrayList<String> patientDetails = new ArrayList<>();
        sc.nextLine();
        System.out.println("\nEnter your name: ");
        patientDetails.add(sc.nextLine());

        System.out.println("\nEnter your phone number: ");
        patientDetails.add(sc.nextLine());

        System.out.println("\nEnter your symptoms: ");
        patientDetails.add(sc.nextLine());

        return patientDetails;
    }

    private void displayPatientDetails(String[] patientDetails) {
        System.out.println("\nPatient Name: " + patientDetails[0]);
        System.out.println("Mobile Number: " + patientDetails[1]);
        System.out.println("Symptoms: " + patientDetails[2]);
    }

    private void selectDoctor() {
        System.out.println("\nSelect Doctor:");
        System.out.println("\n1. Dr. Pranav Mahajan\n2. Dr. Anirudh Mane\n3. Dr. Atharv Kanaki\n4. Dr. Prathamesh Dhanashri\n5. Dr. Akshada Mane");
        int doctorIndex = sc.nextInt();

        if (doctorIndex < 1 || doctorIndex > 5) {
            System.out.println("\nInvalid choice");
            return;
        }

        System.out.println("\nSelect time slot:\n1. Morning\n2. Evening");
        int timeSlotIndex = sc.nextInt();

        if (timeSlotIndex < 1 || timeSlotIndex > 2) {
            System.out.println("\nInvalid choice");
            return;
        }

        bookAppointment(doctorIndex - 1, timeSlotIndex - 1);
    }

    private void getDetails() {
        System.out.println("\nSelect Doctor to see time slots:");
        System.out.println("\n1. Dr. Pranav Mahajan\n2. Dr. Anirudh Mane\n3. Dr. Atharv Kanaki\n4. Dr. Prathamesh Dhanashri\n5. Dr. Akshada Mane");
        int doctorIndex = sc.nextInt();

        if (doctorIndex < 1 || doctorIndex > 5) {
            System.out.println("\nInvalid choice");
            return;
        }

        displayAppointments(doctorIndex - 1);
    }

    private void searchDetails() {
        System.out.println("\nSelect Doctor to search details:");
        System.out.println("\n1. Dr. Pranav Mahajan\n2. Dr. Anirudh Mane\n3. Dr. Atharv Kanaki\n4. Dr. Prathamesh Dhanashri\n5. Dr. Akshada Mane");
        int doctorIndex = sc.nextInt();

        if (doctorIndex < 1 || doctorIndex > 5) {
            System.out.println("\nInvalid choice");
            return;
        }

        System.out.println("\nSelect time slot:\n1. Morning\n2. Evening");
        int timeSlotIndex = sc.nextInt();

        if (timeSlotIndex < 1 || timeSlotIndex > 2) {
            System.out.println("\nInvalid choice");
            return;
        }

        searchDetails(doctorIndex - 1, timeSlotIndex - 1);
    }

    private void cancelAppointment() {
        System.out.println("\nSelect Doctor to cancel appointment:");
        System.out.println("\n1. Dr. Pranav Mahajan\n2. Dr. Anirudh Mane\n3. Dr. Atharv Kanaki\n4. Dr. Prathamesh Dhanashri\n5. Dr. Akshada Mane");
        int doctorIndex = sc.nextInt();

        if (doctorIndex < 1 || doctorIndex > 5) {
            System.out.println("\nInvalid choice");
            return;
        }

        System.out.println("\nSelect time slot:\n1. Morning\n2. Evening");
        int timeSlotIndex = sc.nextInt();

        if (timeSlotIndex < 1 || timeSlotIndex > 2) {
            System.out.println("\nInvalid choice");
            return;
        }

        cancelAppointment(doctorIndex - 1, timeSlotIndex - 1);
    }

    public static void main(String[] args) {
        HospitalAppointment hospital = new HospitalAppointment();
        hospital.initializeDoctors();

        boolean flag = true;

        System.out.println("\n--------------------------Welcome to VIIT Hospital------------------------- ");

        while (flag) {
            System.out.println("\n1. Book Appointment\n2. Get Appointment Details\n3. Search Details\n4. Cancel Appointment\n5. Exit");
            int choice = hospital.sc.nextInt();

            switch (choice) {
                case 1:
                    hospital.selectDoctor();
                    break;
                case 2:
                    hospital.getDetails();
                    break;
                case 3:
                    hospital.searchDetails();
                    break;
                case 4:
                    hospital.cancelAppointment();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("\nInvalid choice");
                    break;
            }
        }
    }
}
