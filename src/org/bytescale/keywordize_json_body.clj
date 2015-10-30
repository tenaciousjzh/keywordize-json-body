(ns org.bytescale.keywordize-json-body
  "Ring based middleware that assists in normalizing keys to standard clojure
keywords."
  (:require [clojure.walk :as kw])
  (:gen-class))

(defn- is-json-request? [request]
  (if-let [type (get-in request [:headers "content-type"])]
    (not (empty? (re-find #"^application/(.+\+)?json" type)))))

(defn keywordize-json-body
  "Runs after ring.middleware.json/wrap-json-body to keywordize string
based keys produced from that into standard clojure keywords. If the request
  is not a JSON request, it calls handler without modifying the body."
  [handler & [options]]
  (fn [request]
    (if (is-json-request? request)
      (let [body (:body request)]
        (handler (assoc request :body (kw/keywordize-keys body))))
      (handler request))))
