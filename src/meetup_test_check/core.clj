(ns meetup-test-check.core
  (:require [inet.data.ip :as ip]))

(defn custom-sort [coll]
  (seq (sort coll)))

(defn ip-allowed? [ip]
  (ip/network-contains? "0.0.0.0/1" ip))
