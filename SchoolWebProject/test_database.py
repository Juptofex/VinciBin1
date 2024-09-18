import sqlite3
import time

# Connect to the SQLite database
conn = sqlite3.connect('courtProj.db')
cursor = conn.cursor()

try:
    # Insert sample data into users table
    cursor.execute("INSERT INTO users (firstname, surname, email, password, status) VALUES ('John', 'Doe', 'john@example.com', 'password123', 'u')")
    cursor.execute("INSERT INTO users (firstname, surname, email, password, status) VALUES ('Jane', 'Smith', 'jane@example.com', 'pass456', 'c')")

    # Insert sample data into courts table
    cursor.execute("INSERT INTO courts (name, location, flooring_type, picture) VALUES ('Court A', 'Location A', 'grass', 'court_a.jpg')")
    cursor.execute("INSERT INTO courts (name, location, flooring_type, picture) VALUES ('Court B', 'Location B', 'clay', 'court_b.jpg')")

    # Insert sample data into tournaments table
    cursor.execute("INSERT INTO tournaments (unique_name, tournament_date, coach, banner, current_nb_participant, max_nb_participant) VALUES ('Tournament X', '2024-04-01', 1, 'banner_x.jpg', 0, 100)")

    # Insert sample data into registration_tournaments table
    cursor.execute("INSERT INTO registration_tournaments (user, tournament) VALUES (1, 1)")

    # Insert sample data into bookings table
    cursor.execute("INSERT INTO bookings (id_court, id_user, date_reservation) VALUES (1, 1, '2024-04-01 10:00:00')")

    # Insert sample data into messages table
    cursor.execute("INSERT INTO messages (text, id_user, id_coach, message_date, response) VALUES ('Message from user', 1, 2, '2024-03-28', 'Response from coach')")

    # Execute queries to retrieve data
    cursor.execute("SELECT * FROM users")
    print("Users:")
    print(cursor.fetchall())

    cursor.execute("SELECT * FROM courts")
    print("\nCourts:")
    print(cursor.fetchall())

    cursor.execute("SELECT * FROM tournaments")
    print("\nTournaments:")
    print(cursor.fetchall())

    cursor.execute("SELECT * FROM registration_tournaments")
    print("\nRegistration Tournaments:")
    print(cursor.fetchall())

    cursor.execute("SELECT * FROM bookings")
    print("\nBookings:")
    print(cursor.fetchall())

    cursor.execute("SELECT * FROM messages")
    print("\nMessages:")
    print(cursor.fetchall())

    # Commit the changes
    conn.commit()

except sqlite3.Error as e:
    print("Error:", e)
    conn.rollback()

finally:
    # Close the connection
    conn.close()

time.sleep(60)
