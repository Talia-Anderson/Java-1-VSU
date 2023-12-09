package org.example;

import java.util.Arrays;
class Container<T>
{
    /**@param INIT_SIZE изначальный размер */
    private final int INIT_SIZE = 1;
    /**Массив на котором будет основан контейнер*/
    private Object[] array = new Object[INIT_SIZE];
    /**
     @param lastIndex - последний элемент*/
    private int lastIndex = 0;

    /**добавление элемента
     @param element - объект, который будем добавлять*/
    public void add(T element)
    {
        if(lastIndex == array.length-1)
            resize(array.length + 1);

        array[lastIndex++] = element;
    }

    /**возвращение по индексу
     @param index - индекс возвращаемого элемента*/
    public T get(int index) {
        return (T) array[index];
    }

    /**удаление элемнта, все остальные смещаются на одну позицию
     @param index - индекс удаляемого элемента*/
    public void removeIndex(int index)
    {
        if (index >= lastIndex)
        {
            return;
        } else
        {
            for (int i = index; i < lastIndex; i++)
                array[i] = array[i + 1];

            array[lastIndex] = null;
            lastIndex--;
            resize(array.length - 1);
        }
    }
    /**Удаляет элемент равный полученному значению.
     @param deleteValue - удаляемое значение*/
    public void removeValue(T deleteValue)
    {
        int index=lastIndex;
        for (int i=0;i<lastIndex;i++ )
        {
            if (array[i] == deleteValue)
            {
                index=i;
                break;
            }
        }
        if (index != lastIndex)
        {
            for (int i = index; i < lastIndex; i++)
                array[i] = array[i + 1];

            array[lastIndex] = null;
            lastIndex--;
            resize(array.length - 1);
        }
    }

    /**преобразование контейнера в строку
     строка возвращается БЕЗ нулевых элементов*/
    @Override
    public String toString()
    {
        Object[] arrayToOut = new Object[lastIndex];
        System.arraycopy(array, 0, arrayToOut, 0, lastIndex);
        return Arrays.toString(arrayToOut);
    }

    /**Возвращает количество*/
    public int size() {
        return lastIndex;
    }

    /**метод для масштабирования
     * @param newLength - новый размер*/
    private void resize(int newLength)
    {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, lastIndex);
        array = newArray;
    }
}
