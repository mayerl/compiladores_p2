import java.util.LinkedList;

public class Stack<T> {

  private LinkedList<T> objects = new LinkedList<T>();

  public void add(T t) {
    this.objects.add(t);
  }

  public T remove() {
    return this.objects.remove(this.objects.size() - 1);
  }

  public boolean isEmpty() {
    return this.objects.size() == 0;
  }
}