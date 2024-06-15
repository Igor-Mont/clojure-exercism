(ns exercism-clojure.pangram)

(defn pangram?
  [s]
  (let [freq (frequencies (map #(Character/toLowerCase %) (filter #(Character/isLetter %) s)))]
    (= 26 (count freq))
    )
  )

(println (pangram? "The quick brown fox jumps over the lazy dog."))