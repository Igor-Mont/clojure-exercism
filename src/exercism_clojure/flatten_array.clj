(ns exercism-clojure.flatten_array)

(defn flatten-aux
  [xs result]
  (if (empty? xs)
    result
    (let [x (first xs)]
      (if (sequential? x)
        (recur (concat x (rest xs)) result)
        (recur (next xs) (conj result x)))
      ))
  )

(defn flatten [arr] ;; <- arglist goes here
  (filter boolean (flatten-aux arr [])))

(println (flatten [1,[2,3,nil,4],[nil],5]))