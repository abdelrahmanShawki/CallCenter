package org.example;

import java.util.*;

interface IEmployee {
    String getEmployeeName();
    void setEmployeeName(String employeeName);

    String getEmployeeType();
    void setEmployeeType(String employeeType);

    int getPriority();
    void setPriority();

    boolean isFree();
    void setFree(boolean isFree);
}

class Respondent implements IEmployee {
    private String employeeName;
    private String employeeType = "Respondent";
    private int priority;
    private boolean isFree = true;

    @Override
    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String getEmployeeType() {
        return employeeType;
    }

    @Override
    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public void setPriority() {
        this.priority = 1;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }

    @Override
    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }
}

class Manager implements IEmployee {
    private String employeeName;
    private String employeeType = "Manager";
    private int priority;
    private boolean isFree = true;

    @Override
    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String getEmployeeType() {
        return employeeType;
    }

    @Override
    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public void setPriority() {
        this.priority = 2;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }

    @Override
    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }
}

class Director implements IEmployee {
    private String employeeName;
    private String employeeType = "Director";
    private int priority;
    private boolean isFree = true;

    @Override
    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String getEmployeeType() {
        return employeeType;
    }

    @Override
    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public void setPriority() {
        this.priority = 3;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }

    @Override
    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }
}

class EmployeePriorityComparator implements Comparator<IEmployee> {
    @Override
    public int compare(IEmployee x, IEmployee y) {
        int priorityComparison = Integer.compare(x.getPriority(), y.getPriority());
        if (priorityComparison == 0) {
            return x.getEmployeeName().compareTo(y.getEmployeeName());
        }
        return priorityComparison;
    }
}

class CallCenter {
    private final SortedSet<IEmployee> employees = new TreeSet<>(new EmployeePriorityComparator());
    private boolean isCustomerSet = false;

    public void addEmployee(IEmployee employee) {
        employee.setPriority();
        employees.add(employee);
    }

    public void handleCustomer() {
        IEmployee employee = null;

        for (IEmployee emp : employees) {
            if (emp.isFree()) {
                employee = emp;
                break;
            }
        }

        if (employee != null) {
            employee.setFree(false);
            isCustomerSet = true;
            System.out.println(employee.getEmployeeName() + " is handling the customer.");
        } else {
            System.out.println("No free employees available.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();

        IEmployee emp1 = new Respondent();
        emp1.setEmployeeName("Respondent1");
        IEmployee emp2 = new Manager();
        emp2.setEmployeeName("Manager1");
        IEmployee emp3 = new Director();
        emp3.setEmployeeName("Director1");

        callCenter.addEmployee(emp1);
        callCenter.addEmployee(emp2);
        callCenter.addEmployee(emp3);

        callCenter.handleCustomer();
    }
}
