{-- Definir las siguientes funciones:
a. valorAbsoluto :: Float →Float, que dado un n´umero
devuelve su valor absoluto.--}

valorAbsoluto :: Float -> Float
valorAbsoluto a
  | a < 0     = -a
  | otherwise = a

{--b. bisiesto :: Int →Bool, que dado un n´umero que representa un año
 indica si el mismo es bisiesto.--}
bisiesto :: Int -> Bool
bisiesto ano
  | ano `mod` 400 == 0 = True
  | ano `mod` 100 == 0 = False
  | ano `mod` 4 == 0   = True
  | otherwise          = False

{--c. factorial :: Int →Int, definida ´unicamente para enteros positivos, 
que computa el factorial.--}
factorial :: Int -> Int
factorial num
  | num == 0  = 1
  | num == 1  = 1
  | otherwise = num * factorial (num - 1)

{--d. cantDivisoresPrimos :: Int →Int, que dado un entero positivo
 devuelve la cantidad de divisores primos.--}
esPrimo :: Int -> Bool
esPrimo n
  | n < 2     = False
  | otherwise = null [x | x <- [2..n-1], n `mod` x == 0]

-- Función principal
cantDivisoresPrimos :: Int -> Int
cantDivisoresPrimos num = length [x | x <- [1..num], num `mod` x == 0, esPrimo x]

{--Contamos con los tipos Maybe y Either definidos como sigue:
data Maybe a = Nothing | Just a
data Either a b = Left a | Right b
a. Definir la funci´on inverso :: Float →Maybe Float que dado un n´umero
 devuelve su inverso multiplicativo. si est´a definido, o Nothing en caso contrario.
--}

inverso :: Float -> Maybe Float
inverso num
  | num == 0  = Nothing
  | otherwise = Just (1 / num)

{--b. Definir la funci´on aEntero :: Either Int Bool →Int que convierte a entero 
una expresi´on que puede ser booleana o entera. En el caso de los booleanos, 
el entero que corresponde es 0 para False y 1 para True--}
aEntero :: Either Int Bool -> Int
aEntero (Left n)  = n
aEntero (Right b) = if b then 1 else 0

{-- Ejercicio 4
Definir las siguientes funciones sobre listas:
a. limpiar :: String →String →String, que elimina todas las apariciones
 de cualquier car´acter de la primera cadena en la segunda. 
 Por ejemplo, limpiar ‘‘susto’’ ‘‘puerta’’ eval´ua a ‘‘pera’’. 
 Nota: String es un renombre de [Char]. La notaci´on ‘‘hola’’ 
 es equivalente a [‘h’,‘o’,‘l’,‘a’] y a ‘h’:‘o’:‘l’:‘a’:[].--}

limpiar :: String -> String -> String
limpiar eliminar texto = [c | c <- texto, not (c `elem` eliminar)]

 {-- b. difPromedio :: [Float] →[Float] que dada una lista de
  n´umeros devuelve la diferencia de cada uno con el promedio general. 
  Por ejemplo, difPromedio [2, 3, 4] eval´ua a [-1, 0, 1].--}
difPromedio :: [Float] -> [Float]
difPromedio xs = [x - promedio | x <- xs]
  where
    promedio = sum xs / fromIntegral (length xs)

{-- c. todosIguales :: [Int] →Bool que indica si una lista de 
enteros tiene todos sus elementos iguales --}
todosIguales :: [Int] -> Bool
todosIguales []     = True
todosIguales (x:xs) = all (== x) xs

{--Ejercicio 5
Dado el siguiente modelo para ´arboles binarios:
data AB a = Nil | Bin (AB a) a (AB a)
definir las siguientes funciones:
a. nullTree :: AB a →Bool que indica si un ´arbol es vac´ıo (i.e. no tiene nodos).
--}

data AB a = Nil | Bin (AB a) a (AB a)

nullTree :: AB a -> Bool
nullTree Nil = True
nullTree _   = False

{-- b. negTree :: AB Bool →AB Bool que dado un ´arbol de booleanos construye 
otro formado por la negaci´on de cada uno de los nodos. --}

negTree :: AB Bool -> AB Bool
negTree Nil = Nil
negTree (Bin izq valor der) = Bin (negTree izq) (not valor) (negTree der)

{-- c. prodTree :: AB Int →Int que calcula el producto de todos los nodos del ´arbol.--}
prodTree :: AB Int -> Int
prodTree Nil = 1
prodTree (Bin izq valor der) = prodTree izq * valor * prodTree der
