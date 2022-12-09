public class HighArray {

    /*
    Задача:
    Поиск элемента в массиве(ускоренный поиск)
    Динамическое выделение памяти
    Сортировка
     */
    private long[] a;      // Инкапсулируем переменные
    private int nElems;   // Счетчик элементов, которые мы добавили

    public HighArray(int max) {     // Создали конструктор
        a = new long[max];      // Выделяю память для массива
        nElems = 0;        // Счетчик добавленных элементов
    }

    public boolean find(long searchKey){    // Поиск элемента
                                            // Переменная - итератор по массиву
        for (int i = 0; i < nElems; i++) {  // Перебираем элементы в цикле
            if (a[i] == searchKey)  return true;    // Если нашли совпадение, выходим из цикла

        }

       return false;   // В противном случае возвращаем
    }



        // Пример метода с полной трассировкой его работы
//    public boolean find(long searchKey){    // Поиск элемента
//        int i;                        // Переменная - итератор по массиву
//        for (i = 0; i < nElems; i++) {  // Перебираем элементы в цикле
//            if (a[i] == searchKey)    // Если нашли совпадение, выходим из цикла
//                break;
//            System.out.println("i " + i);
//        }
//        System.out.println("i после цикла: " + i);
//        if(i == nElems) {     // Если перебрали весь массив, возвращаем false
//            System.out.println("nElems " + nElems);
//            return false;
//        }
//        else
//            return true;    // В противном случае возвращаем
//    }

    public int findIndex(long value){
        for (int i = 0; i < nElems; i++) {
           if(a[i] == value){
               return i;
           }
        }
        return -1;
    }

   // Метод для вставки элемента в массив
    public void insert(long value){
        if(a.length*0.8 <= nElems) {     // Проверяем нет ли дефицита памяти
            long[] temp = a;              // Создаем массив, в котором сохраним старый массив
            a = new long[a.length*2];     // Выделяем дополнительную память
            copyArray(temp);              // Копируем старый массив в новый массив
            System.out.println("Выделили память");    // Выводи сообщение о выделении памяти
        }
            a[nElems] = value;   // Вставка элемента в позицию
            nElems++;      // Увеличение счетчика позиций


    }

    private void copyArray(long[] temp) {      // Копируем старый массив в новый
        for (int i = 0; i < temp.length; i++) {
            a[i] = temp[i];
        }
    }


    // Метод для удаления элемента по значению
    public boolean delete(long value){
        int i;
        for (i = 0; i < nElems; i++) {  // Перебираем добавленные элементы
            if (value == a[i])  break;
                                          // Если совпали значения, выходим из цикла
        }
        if(i == nElems) return false;             // Если перебрали все элементы, возвращаем false
        else{                                     // В противном случае
            for (int j = i; j < nElems; j++) {    // Сдвигаем все элементы после совпавших элементов
                a[j] = a[j + 1];
            }// Свдиг
            nElems--;          //Сокращаем счетчик на 1
            return true;       // Возвращаем true
        }
    }

   // Сортировка пузырьком
    public void sort(){               // Сортировка пузырьком
        long temp;                    // Переменная, в которой мы будем хранить временное значение
        for (int i = 0; i < nElems; i++) {         // Проходим по массиву
            for (int j = 0; j < nElems; j++) {
                if(a[i] < a[j]){         // Если удовлетворенно условие выполняем перестановку
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public void display(){
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
