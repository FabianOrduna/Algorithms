# -*- coding: utf-8 -*-
"""
Sorting algorithms on Python
Author:
    Fabián Orduña Ferreira
"""
class Ordenamientos:
    
    def swap(self,lista, indice1,indice2):
        temp = lista[indice1]
        lista[indice1] = lista[indice2]
        lista[indice2] = temp
        return lista
    
    def bubbleSort(self,lista):
        #print("Ordenamiento bubble sort comienza")
        largo  = len(lista)
        for recorre in range(0,largo):
            for indice in range(0,largo-recorre):
                if(indice < largo-recorre-1):
                    if(lista[indice]>lista[indice+1]):
                        lista = self.swap(lista,indice,indice+1)
            print(lista)
        #return lista    

    def insertionSort(self,lista):
        totLista = len(lista)
        if(totLista>1):
            auxLista = [lista[0]]
            for recorre in range(1,totLista):
                totAux = len(auxLista)
                for indice in range(0,totAux):
                    if(lista[recorre]<= auxLista[indice]):
                        auxLista = auxLista[:indice] + [lista[recorre]] + auxLista[indice:]
                        break
                    if(indice==totAux-1):
                        auxLista = auxLista + [lista[recorre]]
                print(auxLista)        
        else:
            print(lista)

    def deleteMin(self,lista):
        minim = 0
        for indice in range(0,len(lista)):
            if lista[indice]< lista[minim]:
                minim = indice
        num = lista[minim]
        lista = lista[:minim] + lista[minim+1:]
        return num,lista
    
    def deleteMax(self,lista):
        maxi = 0
        for indice in range(0,len(lista)):
            if lista[indice]>lista[maxi]:
                maxi = indice
        num = lista[maxi]
        lista = lista[:maxi] + lista[maxi+1:]
        return num,lista
    

    def selectionSort(self, lista):
        cont = len(lista)
        listaFinal = []
        for indice in range(0,cont):
            obten, lista = self.deleteMin(lista)
            listaFinal = listaFinal + [obten]
            print(listaFinal)
        return listaFinal
            
    #Suponiendo que las dos listas estan ordenadas
    def merge(self,lista1,lista2):
        listaFinal = []
        tot = len(lista1) + len(lista2)        
        for indice in range(0,tot):            
            if  lista1==[]:
                listaFinal = listaFinal + lista2
                break
            if lista2==[]:
                listaFinal = listaFinal + lista1
                break            
            minLis1 = lista1[0]
            minLis2 = lista2[0]            
            if(minLis1<minLis2):
                listaFinal = listaFinal + [minLis1]
                lista1 = lista1[1:]
            if(minLis2<minLis1):
                listaFinal = listaFinal + [minLis2]
                lista2 = lista2[1:]
            if(minLis1==minLis2):
                listaFinal = listaFinal + [minLis1,minLis2]
                lista1 = lista1[1:]
                lista2 = lista2[1:]
        return listaFinal
       

    def mergeSort(self,lista):
        if(len(lista)>1):
            l1 = self.mergeSort(lista[0:int(len(lista)/2)])
            l2 = self.mergeSort(lista[int(len(lista)/2):])
            lista = self.merge(l1,l2)
            print(lista)    
        return lista
        
        

lista1 = [30,5,0, -20, 50, 23, 1, 101,3]
ordena = Ordenamientos()
print("#----------------Ordenamientos-----------------#")
print("De la lista", lista1)
print("\nInsercion:\n")
ordena.insertionSort(lista1)
print("\nSeleccion:\n")
ordena.selectionSort(lista1)
print("\nBurbujeo:\n")
ordena.bubbleSort(lista1)
print("\nMezcla:\n")
ordena.mergeSort(lista1)
print("#----------------------------------------------#")
"""
print("Delete min ")
borrado , listaFin = ordena.deleteMin(lista1)
print("Numero borrado ",borrado)
print("Lista Final",listaFin)

print("Delete max ")
borrado , listaFin = ordena.deleteMax(lista1)
print("Numero borrado ",borrado)
print("Lista Final",listaFin)
"""


    
    
