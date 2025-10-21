public class Person {
    private Name name;
    private int height;
    private Person father;

    public Person(Name name, int height) {
        this.name = name;
        this.height = height;
        this.father = null;
    }

    public Person(Name name, int height, Person father) {
        this.name = name;
        this.height = height;
        this.father = father;
        inheritFromFather();
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
        inheritFromFather();
    }

    private void inheritFromFather() {
        if (father != null) {
            if ((name.getLastName() == null || name.getLastName().isEmpty())
                    && father.name.getLastName() != null) {
                name.setLastName(father.name.getLastName());
            }

            if ((name.getMiddleName() == null || name.getMiddleName().isEmpty())
                    && father.name.getFirstName() != null) {
                name.setMiddleName(father.name.getFirstName() + "ович");
            }
        }
    }

    @Override
    public String toString() {
        return name + ", рост: " + height;
    }
}