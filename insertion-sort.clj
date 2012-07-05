(def a [423, 4, 92, 9, 929, 1, 10, 1, 1, 9281, 817])

(defn insertion-sort
  ([unsorted] (insertion-sort [(first unsorted)] (rest unsorted)))
  ([sorted unsorted]
    (if (empty? unsorted)
      sorted
      (let [unsorted-element (first unsorted)
            rest-unsorted (rest unsorted)]
        (def new-sorted
          (loop [els-before sorted
                 els-after []]
            (cond
              (empty? els-before)
                (concat [unsorted-element] els-after)
              (> (last els-before) unsorted-element)
                (recur (butlast els-before) (concat [(last els-before)] els-after))
              true
                (concat els-before [unsorted-element] els-after))))
        (recur new-sorted rest-unsorted)))))
                

(println "unsorted:" (clojure.string/join ", " a))
(println "  sorted:" (clojure.string/join ", " (insertion-sort a)))
