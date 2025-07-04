import java.util.ArrayList;

public class Room {
    private ArrayList<Person> persons;
    
    public Room() {
        this.persons = new ArrayList<>();
    }
    
    public void add(Person person) {
        this.persons.add(person);
    }
    
    public boolean isEmpty() {
        return this.persons.isEmpty();
    }
    
    public ArrayList<Person> getPersons() {
        return this.persons;
    }
    
    /**
     * 查找并返回身高最矮的人，但不从列表中移除。
     * @return 身高最矮的 Person 对象，如果列表为空则返回 null。
     */
    public Person shortest() {
        return this.findShortestPerson();
    }

    /**
     * 查找、移除并返回身高最矮的人。
     * @return 被移除的身高最矮的 Person 对象，如果列表为空则返回 null。
     */
    public Person take() {
        Person shortestPerson = this.findShortestPerson();
        if (shortestPerson != null) {
            this.persons.remove(shortestPerson);
        }
        return shortestPerson;
    }

    /**
     * 这是一个私有的辅助方法，用于查找并返回列表中身高最矮的人。
     * 它不修改列表。
     * @return 列表中身高最矮的 Person 对象，如果列表为空则返回 null。
     */
    private Person findShortestPerson() {
        if (this.persons.isEmpty()) {
            return null;
        }

        Person shortestPerson = this.persons.get(0);
        for (Person per : this.persons) {
            if (per.getHeight() < shortestPerson.getHeight()) {
                shortestPerson = per;
            }
        }
        return shortestPerson;
    }
}

