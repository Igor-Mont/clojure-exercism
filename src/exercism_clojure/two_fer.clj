(ns exercism-clojure.twoFer)


(defn two-fer
  ([name]
   (let [for-name (if (> (count name) 0) name "you")]
     (str "One for " for-name ", one for me.")))
  ([] (str "One for you, one for me."))
  )

(println (two-fer))