(ns exercism-clojure.sum_of_multiples)

(defn multiple-of
  [x y]
  (zero? (mod x y)))

(println (multiple-of 6 2))

(defn less-than?
  [n threshold]
  (< n threshold))

(defn get-multiples-less-than
  [multiple threshold]
  (take-while #(less-than? % threshold) (filter #(multiple-of % multiple) (range 1 10000)))
  )

(defn sum-of-multiples
  [base threshold]
  (->> base
       (map #(get-multiples-less-than % threshold))
       flatten
       set
       (reduce + 0)
       )
  )

(println (sum-of-multiples '(1) 100))
(println (sum-of-multiples '(3) 7))
