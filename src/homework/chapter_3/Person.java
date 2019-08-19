package www.epochong.homework.chapter_3;



public class Person implements Comparable<Person> {
    String ID;
    Integer life;
    Integer score = 0;

    @Override
    public String toString() {
        return " NewPerson{" +
                "ID='" + ID + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (this.score < o.score ) {
            return 1 ;
        }else if (this.score > o.score ){
            return -1 ;
        }else {
            return this.ID.compareTo(o.ID) ;
        }
    }

    public Person(String ID, int score) {
        this.ID = ID;
        this.score = score;
    }

    public Person(String ID) {
        this.life = 3;
        this.ID = ID;
    }

}
