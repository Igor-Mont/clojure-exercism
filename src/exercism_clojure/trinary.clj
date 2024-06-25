(ns exercism-clojure.trinary)

(defn pow [base exp]
  (int (Math/pow base exp)))

(defn pow-by-index [index n]
  (* (Integer/parseInt (str n)) (pow 3 index)))

(defn to-decimal
  [s]
  (if (= (count (filter #(Character/isDigit %) s)) (count s))
    (->> s
         reverse
         (map-indexed pow-by-index)
         (reduce + 0)
         ) 0)
  )

(println (to-decimal "carrot"))