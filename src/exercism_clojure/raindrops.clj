(ns exercism-clojure.raindrops)

(defn multiple-by? [n multiple] (= (mod n multiple) 0))

(defn raindrop-sound
  [n]
  (case n
    3 "Pling"
    5 "Plang"
    7 "Plong"
    ))

(defn convert
  [n]
  (let [nums [3 5 7]
        sounds (apply str (map #(if (multiple-by? n %) (raindrop-sound %) "") nums))]
    (if (empty? sounds) (str n) sounds))
  )

(println (convert 3))
(println (convert 5))
(println (convert 7))
(println (convert 34))
