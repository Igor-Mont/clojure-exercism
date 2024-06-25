(ns exercism_clojure.hamming)



(defn distance [strand1 strand2]
  (when (= (count strand1) (count strand2))
    (->> strand2
         (map vector strand1)
         (map #(if (apply = %) 0 1))
         (reduce + 0)
         )
    )
  )

(println (distance "GGACTGA" "GGACTGA"))