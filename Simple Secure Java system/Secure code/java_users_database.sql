create Database java_users_database;
use java_users_database;
CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `full_name` varchar(127) NOT NULL,
  `email` varchar(127) NOT NULL,
  `password` varchar(127) NOT NULL,
  `token` varchar(255) NOT NULL,
  `login_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `token_expiry` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `role` varchar(50)
);

INSERT INTO `users` (`id`, `full_name`, `email`, `password`, `token`, `login_time`, `token_expiry`,`role`) VALUES
(1, 'ziad', 'ziad@gmail.com', '$2a$12$lIQZcSouttVXfFt4atbHx.IVCORD/d.8sjwr1d7ol0xsEBnVMNqiK', '577084', '2024-12-26 16:51:44', '2024-12-27 15:13:58','admin');

ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;
select * from `users`;