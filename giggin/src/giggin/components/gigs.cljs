(ns giggin.components.gigs
     (:require [giggin.state :as state]
               [giggin.helpers :refer [format-price]]))

(defn gigs
 []
  [:main
    [:div.gigs
    (for [{:keys [id img title price desc]}(vals @state/gigs)]
                        [:div.gig {:key id}
                          [:img.gig__artwork {:src img :alt title}]
                          [:div.gig__body
                           [:div.gig__title
                            [:div.btn.btn--primary.float--right.tooltip {:data-tooltip "Add to order"
                             :on-click (fn [] (swap! state/orders update id inc))}
                             [:i.icon.icon--plus]] title]
                              [:p.gig__price (format-price price)]
                              [:p.gig_desc desc]]])

     (map (fn [gig]
                       [:div.gig {:key (:id gig)}
                         [:img.gig__artwork {:src (get gig :img) :alt (:title gig)}]
                         [:div.gig__body
                          [:div.gig__title
                           [:div.btn.btn--primary.float--right.tooltip {:data-tooltip "Add to order"}
                            [:i.icon.icon--plus]] (:title gig)]
                             [:p.gig__price (format-price (:price gig))]
                             [:p.gig_desc (:desc gig)]]]) (vals @state/gigs))]])
