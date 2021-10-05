select o.product_name
from ORDERS o
         join CUSTOMERS c
              on o.customer_id = c.id
where c.name = :name;