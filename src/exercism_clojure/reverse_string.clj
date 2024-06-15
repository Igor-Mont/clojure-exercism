(ns exercism-clojure.reverse_string
  (:require [clojure.string :as str]))

(defn reverse-string [s]
  (str/reverse s)
  )

(println (reverse-string "stressed"))
