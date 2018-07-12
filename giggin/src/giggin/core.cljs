(ns giggin.core
  (:require [reagent.core :as r]
            [giggin.components.header :refer [header]]
            [giggin.components.orders :refer [orders]]
            [giggin.components.footer :refer [footer]]
            [giggin.components.gigs :refer [gigs]]
            [giggin.api :as api]
            [giggin.fb.init :refer [firebase-init]]))

(defn app
  []
  [:div.container
  [header]
  [gigs]
  [orders]
  [footer]])

(defn ^:export main
  []
  (api/fetch-gigs)
  (r/render
    [app]
    (.getElementById js/document "app"))
  (firebase-init))
