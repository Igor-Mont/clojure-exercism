(ns exercism_clojure.binary_search)

(defn middle [arr]
  (quot (count arr) 2))

(defn search-for
  [x xs]
  (if (empty? xs) (throw (Exception. "not found"))
                  (let [index-of-middle (middle xs)
                        middle-n (nth xs index-of-middle)]
                    (if (or (> x (last xs)) (< x (first xs)))
                      (throw (Exception. (str x " not found.")))
                      (cond
                        (= x middle-n) index-of-middle
                        (< x middle-n) (search-for x (take index-of-middle xs))
                        (> x middle-n) (+ index-of-middle (search-for x (drop index-of-middle xs)))
                        )
                      )))
  )


(println (search-for 1 []))