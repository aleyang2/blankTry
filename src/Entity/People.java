package Entity;

public class People {

    String name;
    int age;
    private long income;
    private String incomeType;

    public People() {

    }
    public People(String name, int age, long income, String incomeType) {
        this.name = name;
        this.age = age;
        this.income = income;
        this.incomeType = incomeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getIncome() {
        return income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }
}
