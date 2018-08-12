package BookLibrary;
import java.util.*;
public class MainLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Library library = new Library();
        library.name = "MyLibrary";

        for(int i = 0; i < n; i++){
            Book book = new Book();

            String[] bookArgs = scanner.nextLine().split(" ");

            book.setTitle(bookArgs[0]);
            book.setAuthor(bookArgs[1]);
            book.setPublisher(bookArgs[2]);
            book.setRelease_date(bookArgs[3]);
            book.setISBN(bookArgs[4]);
            book.setPrice(Double.parseDouble(bookArgs[5]));

            library.books.add(book);
        }

        output(library);

    }

    public static void output(Library library){
        List<Book> books = library.books;
        HashMap<String, Double> booksByAuthor = new HashMap<String, Double>();

        for(int i = 0; i < books.size(); i++){
            if(booksByAuthor.containsKey(books.get(i).getAuthor())){
                booksByAuthor.put(books.get(i).getAuthor(),
                        booksByAuthor.get(books.get(i).getAuthor()) + books.get(i).getPrice());
            }
            else{
                booksByAuthor.put(books.get(i).getAuthor(), books.get(i).getPrice());
            }
        }

        Map<String, Double> map = new TreeMap<String, Double>(booksByAuthor);
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry)iterator2.next();
            System.out.print(me2.getKey() + ": ");
            System.out.println(me2.getValue());
        }
    }
}
