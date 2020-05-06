package main
import "fmt"
type Books struct {
	title string
	author string
	subject string
	book_id int
}
func changeBook(book *Books) {
	book.title = "book1_change"
	fmt.Println("changeBook",*book)

}
func main() {
	var book1 Books
	book1.title = "book1"
	book1.author = "zuozhe"
	book1.book_id = 1
	changeBook(&book1)
	fmt.Println(book1)
}