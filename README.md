# MultiRestaurantsSystem

Category:
Attributes:
name,
description,
banner

Food:
Attributes:
name,
description,
price,
banner,
ExtrasList

Order:
Attributes:
user,
orderList,
delivery,
restaurant,
status

Review:
Attributes:
numberStars,
userComment

User:
Attributes:
firstName,
lastName,
phoneNumber,
email,
password,
role

Delivery:
Attributes:
order,
address,
date,
fee,
status,
estimatedTime,
person

Person:
Attributes:
name,
phone

Restaurant:
Attributes:
name,
description,
address,
phoneNumber,
email,
banner,
deliveryCost,
reviewStat,
minimumOrder,
deliveryTime

OrderItem:
Attributes:
food,
quantity,
order

OfferedExtras:
Attributes:
name,
weight,
price
