# prova01
 no algoritmo em questao usei todos os codigos de ordenacao de modo que ficasse o mais simplificado possivel, para facilitar o entendimento de qualquer pessoa, ouveram alguns problemas durante o preparo do codigo, devido a quantidade de numeros ordenados, mas no final deu tudo certo, basicamente oque eu fiz foi o seguinte: Parte 1: Preparacao e Geracao de Numeros
Nesta parte do codigo, preparamos o ambiente e geramos tres conjuntos de numeros para ordenacao: um conjunto ja ordenado, um conjunto invertido e um conjunto aleatorio. Primeiro, chamamos a funcao generateNumbersToFile() para criar tres arquivos de texto contendo os numeros. Em seguida, lemos esses arquivos para obter os arrays de numeros correspondentes. Parte 2: Teste e Medicao dos Algoritmos de Ordenacao
Nesta parte, testamos e medimos o desempenho de cada algoritmo de ordenacao para os tres conjuntos de numeros gerados. Utilizamos um loop para percorrer os algoritmos e chamamos a funcao testAndMeasure() para cada um deles, passando o nome do algoritmo e uma copia do array de numeros correspondente. Parte 3: Implementacao dos Algoritmos de Ordenacao
Nesta parte, implementamos os algoritmos de ordenacao que serao testados na parte anterior. Cada algoritmo e uma funcao separada, e cada funcao recebe um array de inteiros como entrada e o ordena. Os algoritmos implementados sao: Bubble Sort, Insertion Sort, Selection Sort, Merge Sort, Quick Sort e Heap Sort.
