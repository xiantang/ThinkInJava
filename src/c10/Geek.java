package c10;


public class Geek {
    public String name;
    public int id;

    public Geek(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if (obj == null || obj.getClass()!= this.getClass())
            return false;
        Geek geek = (Geek) obj;
        return (geek.name == this.name && geek.id == this.id);
    }

    @Override
    public int hashCode() {

        return this.id;
    }
}
