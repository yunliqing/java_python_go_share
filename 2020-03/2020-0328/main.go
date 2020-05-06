package main

import "fmt"
import "time"

func main()  {
	fmt.Println(time.Now())

	timer := time.NewTimer(3*time.Second)
	<-timer.C
	defer timer.Stop()
	
	fmt.Println("时间到",time.Now())

	fmt.Println(time.Now())
	time.Sleep(2*time.Second)
	fmt.Println("时间到",time.Now())

	fmt.Println(time.Now())
	<-time.After(3*time.Second)
	fmt.Println("时间到",time.Now())
}
