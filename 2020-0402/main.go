package main

import "fmt"
import "net"

func main()  {
	 lister,err:=net.Listen("tcp","127.0.0.1:8000")
	 if err !=nil{
	 	fmt.Println(err)
		 return
	 }
	defer lister.Close()
	connt,err1:=lister.Accept()
	if err1!=nil {
		fmt.Println(err1)
		return
	}
	buf:= make([]byte,1024)
	n ,err2:=connt.Read(buf)
	if err2!=nil {
		fmt.Println(err2)
		return
	}
	fmt.Println(string(buf[:n]))
	defer connt.Close()
}