(ns exercism-clojure.armstrong_numbers)

(defn armstrong?
  [num]
  (let [pow (count (str num))]
    (->> num
         str
         (map #(Integer/parseInt (str %)))
         (map #(Math/pow % pow))
         (reduce + 0)
         (== num )
         )
    )
  )

(println (armstrong? 153))
(println (armstrong? 10))
