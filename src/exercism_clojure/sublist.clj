(ns exercism-clojure.sublist)


(defn sublist?
  [sublist list]
  (let [n-sublist (count sublist)]
    (some #(= sublist
              (subvec list % (+ % n-sublist)))
          (range
            (inc (- (count list) n-sublist))))))

(println (sublist? [3, 4] [1, 2, 3, 4, 5]))

(defn classify [list1 list2]
  (cond
    (= list1 list2) :equal
    (sublist? list1 list2) :sublist
    (sublist? list2 list1) :superlist
    :else :unequal)
  )
