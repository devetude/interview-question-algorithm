# Data-Structure-QnA
자료구조 면접 질문과 답

### Q0. [배열(array)](https://gist.github.com/devetude/9cd446755976a89e03c023e98a77903a)에 대해서 설명하시오.
고정된 크기를 갖고 순서대로 번호가 붙은 같은 자료형의 원소들이 연속적인 형태로 구성된 자료구조입니다. 이때 각 원소에 붙은 번호를 흔히 첨자 또는 인덱스(index)라고 부릅니다. 원소들이 연속적으로 메모리에 배치되어있기 때문에 임의의 첨자를 통해 원소의 값을 알아내는데 시간복잡도가 O(1)입니다. 따라서 임의의 접근이 가능한 자료구조에 속합니다.

임의의 첨자를 통해 원소의 값을 도출하거나 해당 위치에 새로운 원소를 대입하는 연산은 시간복잡도가 O(1)로 매우 빠르나, 새로운 원소를 삽입하거나 삭제하는 경우 배열의 크기를 조정하여 이전 원소들을 복사해야하는 연산이 실행되지 때문에 시간복잡도가 O(n)으로 느립니다.

### Q1. [배열 리스트(array list)]()에 대해서 설명하시오.
![arraylist.png](https://github.com/devetude/Data-Structure-QnA/blob/master/images/arraylist.png)

배열을 이용하여 리스트를 구현한 자료구조입니다. 배열의 특성상 데이터를 리스트의 처음이나 중간에 저장하면 이후의 데이터들이 한칸씩 뒤로 물러나야하며 삭제의 경우 삭제하는 데이터 이후 데이터들이 순차적으로 한칸씩 당겨져야하기 때문에 비효율적입니다. 하지만 단순히 첨자를 이용하여 데이터를 가져오는 경우에는 배열의 특징을 그대로 가지고 있기 때문에 매우 빠른 속도를 보여줍니다.

### Q2. 연결 리스트(linked list)에 대해서 설명하시오.
![singlylinkedlist.png](https://github.com/devetude/Data-Structure-QnA/blob/master/images/singlylinkedlist.png)

[단순 연결 리스트 (singly linked list)](https://gist.github.com/devetude/eaf18d184ce96f7828a7dc79538d6f24) : 단순 연결 리스트는 노드에 다음 노드의 주소를 가리키는 정보만 추가되어있는 가장 단순한 형태의 연결 리스트입니다. 가장 마지막 원소를 찾으려면 처음부터 리스트의 끝까지 탐색해야하기 때문에 시간복잡도가 O(n)입니다. 이 자료구조는 가장 첫번째 노드의 참조 주소를 잃어버릴 경우 데이터 전체를 못 쓰게되는 단점이 있습니다. 또한 다음 노드를 참조하는 주소 중 하나가 잘못되는 경우에도 리스트가 끊어져 뒤쪽 자료들을 유실할 수 있는 불안정적인 자료구조입니다.

![doublylinkedlist.png](https://github.com/devetude/Data-Structure-QnA/blob/master/images/doublylinkedlist.png)

[이중 연결 리스트 (doubly linked list)](https://gist.github.com/devetude/5a60367ec4e5f2314221f2407e7a3da6) : 다음 노드의 참조뿐만 아니라 이전 노드의 참조도 같이 가리키게한 리스트 자료구조입니다. 단순 연결 리스트와 다르게 뒤에서부터 탐색하는 것이 빠르며 특정 노드를 삭제하는데 훨씬 간단하게 구현할 수 있습니다. 또한 첫 노드와 마지막 노드 중 하나를 가지고 있다면 전체 리스트를 순회할 수 있기 때문에 끊어진 리스트를 복구하는게 가능합니다. 그러나 관리해야할 참조 주소가 2개로 삽입이나 정렬의 경우 작업량이 더 많고 소모되는 메모리의 양도 많습니다.

![circularlinkedlist.png](https://github.com/devetude/Data-Structure-QnA/blob/master/images/circularlinkedlist.png)

원형 연결 리스트(circular linked list) : 단순 연결 리스트에서 마지막 원소를 null이 나닌 첫 노드의 주소를 가리키게하면 원형 연결 리스트 자료구조가 됩니다. 이 방법은 이중 연결 리스트에도 마찬가지로 적용됩니다.

### Q3. [스택(stack)](https://github.com/devetude/Data-Structure-QnA)에 대해서 설명하시오.
![stack.png](https://github.com/devetude/Data-Structure-QnA/blob/master/images/stack.png)

스택은 먼저 삽입된 요소가 가장 마지막에 제거되는 후입선출 형태의 자료구조입니다. 새롭게 들어가는 요소의 위치를 스택 포인터 혹은 탑 포인터라고 지칭합니다. 보통 삽입은 push, 제거는 pop, 가장 위에 있는 요소를 확인하기 위해 peek이라는 실행을 합니다. 간단하게는 배열로 구현할 수 있으며, 연결 리스트를 이용하여 구현할 수도 있습니다. 이러한 스택의 최대 저장량을 초과했을 경우를 스택 오버플로우(overflow)라 지칭합니다. 또한 시스템 스택은 메소드를 호출하거나 재귀적인 호출에서 복귀 지점을 찾아가는데 사용됩니다.

### Q4. 큐(queue)에 대해서 설명하시오.
![queue.png](https://github.com/devetude/Data-Structure-QnA/blob/master/images/stack.png)

큐는 먼저 삽입된 요소가 가장 먼저 제거되는 선입선출 형태의 자료구조입니다. 새롭게 들어오는 위치는 큐의 가장 뒷편인 rear 혹은 back이며 제거되는 부분의 위치를 front라고합니다. 보통 연결 리스트를 이용하여 구현합니다. 큐의 특수한 형태로 원형 큐와 덱이 있습니다.

### Q5. [덱(dequeue)]()에 대해서 설명하시오.

### Q6. [트리(tree)]()에 대해서 설명하시오.

### Q7. [힙(heap)]()에 대해서 설명하시오.

### Q8. [트라이(trie)]()에 대해서 설명하시오.

### Q9. [인접 행렬(adjacency matrix)]()에 대해서 설명하시오.

### Q10. [인접 리스트(adjacency list)]()에 대해서 설명하시오.

### Q11. [연관 배열(associative array)]()에 대해서 설명하시오.

### Q12. [연관 리스트(associative list)]()에 대해서 설명하시오.

### Q12. [해시 테이블(hash table)]()에 대해서 설명하시오.
