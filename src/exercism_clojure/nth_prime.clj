(ns exercism-clojure.nth_prime)

(defn prime? [n]
  (if (> n 1)
    (loop [i 2]
      (println i (* i i) n)
      (cond
        (> (* i i) n) true
        (zero? (mod n i)) false
        :else (recur (inc i))))
    false))

(println (prime? 4))

(defn nth-prime
  "Returns the prime number in the nth position."
  [n]
  (if (zero? n)
    (throw (IllegalArgumentException. "there is no zeroth time"))
    (last (take n (filter prime? (range 100000000)))))
  )

;(println (nth-prime 0))
;
;(println (take 2 (range 10000)))