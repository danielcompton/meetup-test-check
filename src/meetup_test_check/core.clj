(ns meetup-test-check.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn custom-sort [coll]
  (rseq coll))

