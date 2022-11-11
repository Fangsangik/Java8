package com.example.java.Etc;
/*
PermGen 메모리 영역이 사라지고 -> MetaSpace 영역이 생김
PermGen 영역은 Permanent Generation 클레스 메타데이터를 담고 있던곳
클레스를 로딩할때 정보들을 담아 놓는 곳, 클레스를 많이 사용 하면 사용할 수록 공간에 데이터가 점점더 쌓이게 된다.
Heap 영역의 일부 => 자바에서 메모리 관리하는 부분을 Heap이라고 한다. (Young Generation , Old Generation)

<Java 8 이전>
OS가 제공하는 메모리 명령 위에 JVM이 관리하는 메모리 영역을 Heap 영역이 있다
그 안에 Eden - YoungGenration / Old - OldGeneration / PermGen
클레스를 많이 로딩 하거나 생성하는경우 PermGen 영역이 꽉 차는 경우가 있다. (고정된 Size)

<Java 8 이후>
Native Memory 영역이 있음, JVM Heap에 PermGen 영역이 사라지고
Eden: Young Gen / Old Gen // MetaSpace라는 Native Memory에 자리를 잡았다. => 필요한 만큼 계속 차오른다.

MetaSpace에 최대값을 설정해서 사용 / Monitoring을 사용해서 얼만큼에 메모리를 사용 하고 있는지를 찾아본다.
 */
public class GarbageCollector {
    public static void main(String[] args) {
        
    }
}
