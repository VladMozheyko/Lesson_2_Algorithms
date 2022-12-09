public class LowArray {

    private long[] a;           // Поле массива

    public LowArray(int size) {   // Конструктор, который принимает размер массива и создает массив
          a = new long[size];     // Выделяем память для массива
    }

    public void setElem(int index, long value){   // Добавляем элементы
        a[index] = value;
    }

    public long getElem(int index){         // Получаем элемент по индексу
        return a[index];
    }

}
