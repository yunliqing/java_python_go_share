package main

import (
	"fmt"
	"strings"
)
import "net"

func vue(addr net.Conn)  {
	fmt.Println("第一次进入链接")
	stastus :=addr.RemoteAddr()
	fmt.Println("11111111111111",stastus)
	defer addr.Close()
	buf:=make([]byte,2048)
	for  {
		n,err:=addr.Read(buf)
		if err!=nil{
			return
		}
        fmt.Printf("%s\n",string(buf[:n]))
		if "exit"==string(buf[:n]){
			return
		}
		addr.Write([]byte(strings.ToUpper(string(buf[:n]))))

	}
}



func main()  {

	conn,err:=net.Listen("tcp","127.0.0.1:8000")
	if err!=nil {
		fmt.Println(err)
		return
	}

	for  {
		ser,err1 :=conn.Accept()
		if err1!=nil {
			fmt.Println(err1)
			return
		}
		go vue(ser)
	}
}

