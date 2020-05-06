package main
import "fmt"
import "time"
func main()  {
	timer := time.NewTimer(2*time.Second)
	
	defer timer.Stop()

	fmt.Println("现在时间",time.Now())
	t :=<- timer.C
	fmt.Println("延迟后的时间",t)


}