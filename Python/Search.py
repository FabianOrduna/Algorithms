# -*- coding: utf-8 -*-
"""
Searching algorithms on Python
Created on Sat Jan  5 12:04:45 2019
@author: Fabián Orduña Ferreira
"""

class Search:
    
    #This algorithm works with order and unorder lists.
    #Return the index (starting with 0) of the first
    #element that matches the searched one.
    #If there is no element, it returns -1
    def linearSearch(self, list, elem, order):
        res = -1
        
        index = 0
        leng = len(list)
        found = False
        while(not(found) and index < leng):
            if list[index] == elem:
                res = index
                found = True
            if order == True and list[index]>elem:
                found = True  
            index +=1
        return res
    
    #This algorithm search an element in an order list.
    #Return the index (starting with 0) of the element
    #that matches the searched one.
    #If there is no element, it returns -1
    def binarySearch(self,list,elem):
        firstIndex = 0
        lastIndex = len(list) -1
        
        found  = False
        res = -1
        
        while(not(found) and firstIndex < lastIndex):
            print(firstIndex,lastIndex)
            if(list[firstIndex]==elem):
                found = True
                res = firstIndex
            else:
                if(list[lastIndex]==elem):
                    found = True
                    res = lastIndex
            
            middleIndex = int((firstIndex+lastIndex)/2)
            if( list[middleIndex]== elem):
                found = True
                res = middleIndex
            else:
                if(elem<list[middleIndex]):
                    firstIndex +=1
                    lastIndex = middleIndex -1
                else:
                    firstIndex = middleIndex +1
                    lastIndex -=1
        return res
    
s = Search()
lista = [-25,10,45,85,86,90,111,50]
elem = 90
print("Buscando el elemento: ",elem)
print("\nLineal ordenada")
print(s.linearSearch(lista,elem,True))
print("\nBinaria ordenada")
print(s.binarySearch(lista,elem))
print("")



















