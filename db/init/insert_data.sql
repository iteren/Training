\connect mywallet

SET search_path TO mywallet;

INSERT INTO mywallet.expense_plan(plan_id) VALUES ('May 2021');
INSERT INTO mywallet.expense_plan(plan_id) VALUES ('June 2021');
INSERT INTO mywallet.expense_plan(plan_id) VALUES ('July 2021');

INSERT INTO mywallet.expense_item(plan_id, name, "limit") VALUES ('May 2021', 'Bank', 100000);
INSERT INTO mywallet.expense_item(plan_id, name, "limit") VALUES ('May 2021', 'General', 30000);
INSERT INTO mywallet.expense_item(plan_id, name, "limit") VALUES ('May 2021', 'House', 5000);
INSERT INTO mywallet.expense_item(plan_id, name, "limit") VALUES ('May 2021', 'Car', 5000);

INSERT INTO mywallet.expense_item(plan_id, name, "limit") VALUES ('June 2021', 'Bank', 120000);
INSERT INTO mywallet.expense_item(plan_id, name, "limit") VALUES ('June 2021', 'House', 4000);
INSERT INTO mywallet.expense_item(plan_id, name, "limit") VALUES ('June 2021', 'Car', 5000);

INSERT INTO mywallet.expense_item(plan_id, name, "limit") VALUES ('July 2021', 'Bank', 700000);
INSERT INTO mywallet.expense_item(plan_id, name, "limit") VALUES ('July 2021', 'General', 25000);

INSERT INTO mywallet.expense_record(item_id, name, currency, amount, expense_time)
select sub.item_id, 'Acura Gas', 'UAH', 1280, now()
from mywallet.expense_item sub where sub.name = 'Car' and sub.plan_id = 'June 2021';

INSERT INTO mywallet.expense_record(item_id, name, currency, amount, expense_time)
select sub.item_id, 'Nissan Gas', 'UAH', 1100, now()
from mywallet.expense_item sub where sub.name = 'Car' and sub.plan_id = 'June 2021';

INSERT INTO mywallet.expense_record(item_id, name, currency, amount, expense_time)
select sub.item_id, 'Electricity', 'UAH', 850, now()
from mywallet.expense_item sub where sub.name = 'House' and sub.plan_id = 'June 2021';

INSERT INTO mywallet.income_source(
    plan_id, name, currency, amount, balance)
VALUES ('June 2021', 'Ihors card', 'UAH', 10000, 4000);

INSERT INTO mywallet.income_source(
    plan_id, name, currency, amount, balance)
VALUES ('June 2021', 'Olhas card', 'UAH', 3000, 250);