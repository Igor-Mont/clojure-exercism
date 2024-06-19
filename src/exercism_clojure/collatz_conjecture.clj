(ns exercism-clojure.collatz_conjecture)

(defn one? [n] (= n 1))

(defn expr-even
  [n]
  (/ n 2))

(defn expr-odd
  [n]
  (inc (* n 3)))

(defn expr
  [n]
  (if (even? n) (expr-even n) (expr-odd n)))

(defn collatz-conjecture
  [n steps]
  (println n)
  (if (one? n)
    steps
    (recur (expr n) (inc steps)))
  )

(defn collatz
  [num]
  (cond
    (one? num) 0
    (pos? num) (collatz-conjecture num 0)
    :else (throw (ex-info "number must be non-negative" {}))
    )
  )

;(println (collatz 12))
;(println (collatz 0))
;(println (collatz -12))
;(println (collatz 1))
(println (collatz 16))

