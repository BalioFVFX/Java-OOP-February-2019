public class Bulgarian implements Person {
    private String name;
    public Bulgarian(String name) {
        this.name = name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
